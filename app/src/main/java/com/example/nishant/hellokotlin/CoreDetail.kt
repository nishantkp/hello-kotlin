/*
 * Copyright (c) 2018
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * File Created on 26/05/18 9:53 PM by nishant
 * Last Modified on 26/05/18 9:53 PM
 */

package com.example.nishant.hellokotlin

import android.annotation.SuppressLint
import android.databinding.Bindable
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry
import java.text.SimpleDateFormat
import java.util.*

class CoreDetail(var language: String = "Kotlin") : Observable {

    private val registry = PropertyChangeRegistry()

    var dateString: String

    var name: String = "user"
        @Bindable get
        set(value) {
            field = value
            registry.notifyChange(this, BR.name)
        }

    init {
        val date: Date = Calendar.getInstance().time
        @SuppressLint("SimpleDateFormat")
        val dateFormat = SimpleDateFormat("dd-MMM-yyyy")
        dateString = dateFormat.format(date).toString()
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        registry.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        registry.add(callback)
    }
}