package com.wsr.katanarecorder.main.list.detail.edit

import android.app.Activity
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher

class ListEditImageSetter(activity: Activity) {

    private lateinit var getContent: ActivityResultLauncher<String>
    private lateinit var dispatchTakePicture: ActivityResultLauncher<Uri>

    //private val registry = activity.activityResult
}