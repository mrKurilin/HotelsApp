package ru.mrkurilin.hotelsApp.ui.views

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputEditText
import ru.mrkurilin.hotelsApp.ui.R

const val PHONE_CHARS_COUNT = 10
const val PHONE_TEXT_LENGTH = 18

class PhoneInputEditText @JvmOverloads constructor(
    private val context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.editTextStyle
) : TextInputEditText(context, attrs, defStyleAttr) {

    private val initText = "+7 (***) ***-**-**"
    private var currentText = ""

    override fun onSelectionChanged(selStart: Int, selEnd: Int) {
        super.onSelectionChanged(selStart, selEnd)
        if (text?.isEmpty() == true) {
            return
        }

        if (selStart != selEnd) {
            setSelection(text!!.length)
            return
        }

        if (text?.contains("*") == true) {
            val indexToSet = text?.indexOf("*") ?: PHONE_TEXT_LENGTH
            setSelection(if (indexToSet == -1) PHONE_TEXT_LENGTH else indexToSet)
        } else {
            setSelection(PHONE_TEXT_LENGTH)
        }
    }

    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
        if (focused && text?.isEmpty() != false) {
            setText(initText)
        }
        if (!focused && editableText.toString() == initText) {
            setText("")
        }
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        if (text.isNullOrBlank() || text.toString() == initText || text == currentText) {
            return
        }

        if (start == 0 && lengthAfter == lengthBefore) {
            return
        }

        if (!text.toString().startsWith("+7 (")) {
            setText(initText)
            return
        }

        val currentCharsArray = Array(PHONE_CHARS_COUNT) { '*' }

        var chars = text.toString().removePrefix("+7 (")
            .replace(")", "")
            .replace("*", "")
            .replace(" ", "")
            .replace("-", "")
            .toMutableList()

        if (text.count { it == '-' || it == ' ' } < 4) {
            chars.removeLast()
        }

        if (chars.size > 10) {
            chars = chars.subList(0, 10)
        }

        chars.forEachIndexed { index, char ->
            currentCharsArray[index] = char
        }

        currentText = context.getString(
            R.string.masked_phone_number,
            currentCharsArray[0],
            currentCharsArray[1],
            currentCharsArray[2],
            currentCharsArray[3],
            currentCharsArray[4],
            currentCharsArray[5],
            currentCharsArray[6],
            currentCharsArray[7],
            currentCharsArray[8],
            currentCharsArray[9]
        )
        setText(currentText)
    }
}