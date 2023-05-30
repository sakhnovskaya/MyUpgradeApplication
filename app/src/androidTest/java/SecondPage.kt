import BasePage.Companion.waitingTimeOut
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until

class SecondPage: BasePage() {

    private val submitButtonSelector =
        By.res("ru.tinkoff.myupgradeapplication:id/button_submit")
    private val previousButtonSelector =
        By.res("ru.tinkoff.myupgradeapplication:id/button_second")

    private val enterLoginSelector =
        By.res("ru.tinkoff.myupgradeapplication:id/edittext_login")
    private val enterPasswordSelector =
        By.res("ru.tinkoff.myupgradeapplication:id/edittext_password")

    fun pressSubmitButton() {
        pressButton(submitButtonSelector)
    }

    fun pressPreviousButton() {
        pressButton(previousButtonSelector)
    }

    fun enterLogin(loginValue: String) {
        device
            .wait(Until.findObject(enterLoginSelector), waitingTimeOut)
            .text = loginValue
    }

    fun enterPassword(passwordValue: String) {
        device
            .wait(Until.findObject(enterPasswordSelector), waitingTimeOut)
            .text = passwordValue
    }

    companion object {
        const val TEST_LOGIN = "Lisa"
        const val TEST_PASSWORD = "Tinkoff"
    }
}
