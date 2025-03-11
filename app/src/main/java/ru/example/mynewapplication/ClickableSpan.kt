import android.graphics.Color
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View

class ClickableSpan(private val onClickAction: () -> Unit) : ClickableSpan() {
    override fun onClick(widget: View) {
        onClickAction()
    }

    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        ds.color = Color.BLUE    // Устанавливаем нужный цвет для кликабельного текста
        ds.isUnderlineText = true // Подчеркивание
    }
}
