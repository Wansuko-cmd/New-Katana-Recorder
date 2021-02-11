package com.wsr.katanarecorder.db

/*
id:シングルトンのid
title:銘
url:写真のファイル名
value:刀ごとの詳細を記述
*/

data class SampleModel(
        val id: Int = -404,
        val title: String = "",
        var url: String? = null,
        val value: MutableList<KatanaValue> = mutableListOf()
)