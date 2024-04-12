package com.example.testapp.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class CustomChip: Chip {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun setChecked(checked: Boolean) {
        super.setChecked(checked)
        isCloseIconVisible = checked
    }

}

