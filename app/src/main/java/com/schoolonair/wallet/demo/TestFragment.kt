package com.schoolonair.wallet.demo

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels

class TestFragment: Fragment() {
    val sharedVM: MainViewModel by viewModels()
}