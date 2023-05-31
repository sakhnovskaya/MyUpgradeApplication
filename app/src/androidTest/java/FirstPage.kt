import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import ru.tinkoff.myupgradeapplication.R


class FirstPage : BasePage() {

    private val nextButtonSelector = By.res("ru.tinkoff.myupgradeapplication:id/button_first")
    private val dialogButtonSelector = By.res("ru.tinkoff.myupgradeapplication:id/dialog_button")
    private val changeButtonSelector = By.res("ru.tinkoff.myupgradeapplication:id/change_button")

    val titleDialog = findObject("Важное сообщение")
    val messageDialog = findObject("Теперь ты автоматизатор")

    fun pressNextButton() {
        pressButton(nextButtonSelector)
    }

    fun pressDialogButton() {
        pressButton(dialogButtonSelector)
    }

    fun pressChangeButton() {
        pressButton(changeButtonSelector)
    }

    companion object {
        val FIRST_TEXT = InstrumentationRegistry.getInstrumentation().targetContext.getString(
            R.string.first_text
        )
        val SECOND_TEXT = InstrumentationRegistry.getInstrumentation().targetContext.getString(
            R.string.second_text
        )
    }
}
