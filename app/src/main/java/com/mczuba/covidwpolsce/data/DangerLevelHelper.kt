package com.mczuba.covidwpolsce.data

import com.mczuba.covidwpolsce.api.CovidDataProvider

class DangerLevelHelper(val Data: CountryHistory) {
    val population = 37000000

    enum class ThreatLevel
    {
        one,
        two,
        three,
        four,
        five
    }

    fun getThreatRating(score: Int) : ThreatLevel
    {
        if(score<20) return ThreatLevel.one
        else if(score<40) return ThreatLevel.two
        else if(score<60) return ThreatLevel.three
        else if(score<80) return ThreatLevel.four
        else return ThreatLevel.five
    }

    fun calculateOverallThreat() : Int
    {
        var points = 0;
        points += calculateActiveThreat()
        points += calculateInfectionsThreat()
        points += calculateForecastThreat()
        points += calculatePositiveTestsThreat()
        return points
    }

    fun calculateInfectionsThreat() : Int
    {
        return 0;
    }

    fun calculateActiveThreat() : Int
    {
        return 0;
    }

    fun calculatePositiveTestsThreat() : Int
    {
        return 0;
    }

    fun calculateForecastThreat() : Int
    {
        return 0;
    }

}