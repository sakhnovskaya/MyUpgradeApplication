import FirstPage.Companion.FIRST_TEXT
import SecondPage.Companion.LOGIN_HINT
import SecondPage.Companion.PASSWORD_HINT
import SecondPage.Companion.TEST_LOGIN
import SecondPage.Companion.TEST_PASSWORD
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kaspersky.kaspresso.internal.systemscreen.NotificationsFullScreen.pressBack
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.myupgradeapplication.MainActivity

@RunWith(AndroidJUnit4::class)
class AppUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkShowPasswordError() {
        with(FirstPage()) {
            pressNextButton()
        }
        with(SecondPage()) {
            enterLogin(TEST_LOGIN)
            pressSubmitButton()
            assert(checkText("Password field must be filled!"))
        }
    }

    @Test
    fun checkShowLoginError() {
        with(FirstPage()) {
            pressNextButton()
        }
        with(SecondPage()) {
            enterPassword(TEST_PASSWORD)
            pressSubmitButton()
            assert(checkText("Login field must be filled!"))
        }
    }

    @Test
    fun checkShowAllFieldsEmptyError() {
        with(FirstPage()) {
            pressNextButton()
        }
        with(SecondPage()) {
            pressSubmitButton()
            assert(checkText("Both of fields must be filled!"))
        }
    }

    @Test
    fun checkShowDialogAfterDialogButton() {
        with(FirstPage()) {
            pressDialogButton()
            waiting()
            assert(titleDialog.exists())
            assert(messageDialog.exists())
        }
    }

    @Test
    fun checkNoShowDialog() {
        with(FirstPage()) {
            pressDialogButton()
            pressBack()
            waiting()
            assertFalse(titleDialog.exists())
            assertFalse(messageDialog.exists())
        }
    }

    @Test
    fun checkFirstText_AfterBackToPage() {
        with(FirstPage()) {
            pressChangeButton()
            pressNextButton()
        }
        with(SecondPage()) {
            pressPreviousButton()
        }
        with(FirstPage()) {
            assert(checkText(FIRST_TEXT))
        }
    }

    @Test
    fun checkNoLoginNoPasswordView() {
        with(FirstPage()) {
            pressNextButton()
        }
        with(SecondPage()) {
            enterLogin(TEST_LOGIN)
            enterPassword(TEST_PASSWORD)
            pressPreviousButton()
        }
        with(FirstPage()) {
            pressNextButton()
        }
        with(SecondPage()) {
            assertEquals(LOGIN_HINT, loginFieldObject.text)
            assertEquals(PASSWORD_HINT, passwordFieldObject.text)
        }
    }
}
