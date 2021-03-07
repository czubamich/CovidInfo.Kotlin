package com.mczuba.covidwpolsce.vm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.anychart.APIlib
import com.anychart.AnyChart
import com.anychart.AnyChart.cartesian
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.enums.MarkerType
import com.anychart.graphics.vector.Stroke
import com.mczuba.covidwpolsce.data.CountryHistory
import com.mczuba.covidwpolsce.data.RegionHistory
import com.mczuba.covidwpolsce.databinding.FragmentRegiondetailBinding
import com.mczuba.covidwpolsce.databinding.FragmentSummaryBinding
import kotlinx.android.synthetic.main.fragment_prepare.view.*
import java.text.SimpleDateFormat


class RegionDetailFragment : Fragment() {
    private val args: RegionDetailFragmentArgs by navArgs()
    private lateinit var binding : FragmentRegiondetailBinding
    private val viewModel by lazy {
        ViewModelProvider(this).get(RegionDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegiondetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        viewModel.initFor(args.regionArg)
        binding.viewmodel = viewModel

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        viewModel.data.observe(viewLifecycleOwner, dataObserver)
    }

    private val dataObserver = Observer<List<RegionHistory>> { history ->
        if(history.count()==0)
            return@Observer

        val dateformat = SimpleDateFormat("dd.MM.yy")

        APIlib.getInstance().setActiveAnyChartView(binding.chartActive);

        //active
        val activecases = AnyChart.line()
        activecases.animation(true)
        activecases.padding(10.0, 20.0, 5.0, 20.0)
        activecases.xScroller(true)

        activecases.crosshair().enabled(true)
        activecases.crosshair()
            .yLabel(true) //TODO ystroke
            .yStroke(null as Stroke?, null, null, null as String?, null as String?)
        activecases.title("Aktywne przypadki");


        val data3: MutableList<DataEntry> = ArrayList()
        history.forEach{
            data3.add(ValueDataEntry(dateformat.format(it.date), it.active))
        }

        activecases.line(data3)
        binding.chartActive.setChart(activecases)


        //cases
        APIlib.getInstance().setActiveAnyChartView(binding.chartCases);

        val cases = AnyChart.line()
        cases.animation(true)
        cases.padding(10.0, 20.0, 5.0, 20.0)
        cases.xScroller(true)

        cases.crosshair().enabled(true)
        cases.crosshair()
            .yLabel(true) // TODO ystroke
            .yStroke(null as Stroke?, null, null, null as String?, null as String?)
        cases.title("Suma potwierdzonych przypadków");

        val data: MutableList<DataEntry> = ArrayList()
        history.forEach{
            data.add(ValueDataEntry(dateformat.format(it.date), it.cases))
        }

        cases.line(data)
        binding.chartCases.setChart(cases)

        //newcases
        APIlib.getInstance().setActiveAnyChartView(binding.chartNewCases);

        val newcases = AnyChart.line()
        newcases.animation(true)
        newcases.padding(10.0, 20.0, 5.0, 20.0)
        newcases.xScroller(true)

        newcases.crosshair().enabled(true)
        newcases.crosshair()
            .yLabel(true) // TODO ystroke
            .yStroke(null as Stroke?, null, null, null as String?, null as String?)
        newcases.title("Nowe potwierdzone przypadki");


        val data2: MutableList<DataEntry> = ArrayList()

        history.forEach{
            data2.add(ValueDataEntry(dateformat.format(it.date), it.newCases))
        }

        newcases.line(data2)
        binding.chartNewCases.setChart(newcases)
    }
}