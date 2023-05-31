import androidx.test.uiautomator.By

class SecondPage : BasePage() {

    private val submitButtonSelector =
        By.res("ru.tinkoff.myupgradeapplication:id/button_submit")
    private val previousButtonSelector =
        By.res("ru.tinkoff.myupgradeapplication:id/button_second")

    private val enterLoginSelector =
        By.res("ru.tinkoff.myupgradeapplication:id/edittext_login")
    private val enterPasswordSelector =
        By.res("ru.tinkoff.myupgradeapplication:id/edittext_password")

    val loginFieldObject = waitAndFindObject(enterLoginSelector)
    val passwordFieldObject = waitAndFindObject(enterPasswordSelector)

    fun pressSubmitButton() {
        pressButton(submitButtonSelector)
    }

    fun pressPreviousButton() {
        pressButton(previousButtonSelector)
    }

    fun enterLogin(loginValue: String) {
        loginFieldObject.text = loginValue
    }

    fun enterPassword(passwordValue: String) {
        passwordFieldObject.text = passwordValue
    }

    companion object {
        const val TEST_LOGIN = "Lisa"
        const val TEST_PASSWORD = "Tinkoff"
        const val LOGIN_HINT = "Login"
        const val PASSWORD_HINT = "Password"
    }
}
