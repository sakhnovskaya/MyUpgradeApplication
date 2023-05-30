import FirstPage.Companion.FIRST_TEXT
import SecondPage.Companion.TEST_LOGIN
import SecondPage.Companion.TEST_PASSWORD
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import io.github.kakaocup.kakao.screen.Screen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.myupgradeapplication.MainActivity

@RunWith(AndroidJUnit4::class)
class AppUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val device: UiDevice =
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Test
    fun checkShowPasswordError() {
        with(FirstPage()) {
            pressNextButton()
        }
        with(SecondPage()) {
            enterLogin(TEST_LOGIN)
            pressSubmitButton()
            checkText("Password field must be filled!")
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
            checkText("Login field must be filled!")
        }
    }

    @Test
    fun checkShowAllFieldsError() {
        with(FirstPage()) {
            pressNextButton()
        }
        with(SecondPage()) {
            pressSubmitButton()
            checkText("Both of fields must be filled!")
        }
    }

    @Test
    fun checkShowDialogAfterDialogButton() { // хз
        with(FirstPage()) {
            pressDialogButton()
            checkText("Важное сообщение")
            checkText("Теперь ты автоматизатор")
        }
    }

    @Test
    fun checkNoShowDialog() { // хз
        with(FirstPage()) {
            pressDialogButton()
        }
        device.pressBack()
        Screen.idle(2000L)
        with(SecondPage()) {
            checkText("Важное сообщение")
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
            checkText(FIRST_TEXT)
        }
    }

    @Test
    fun checkNoLoginNoPassword() { // хз
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

        }
    }
}
