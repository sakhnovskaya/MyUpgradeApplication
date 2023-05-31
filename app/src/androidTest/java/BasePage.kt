import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until.findObject
import androidx.test.uiautomator.Until.hasObject
import io.github.kakaocup.kakao.screen.Screen

open class BasePage {

    private val device: UiDevice =
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    fun waitAndFindObject(objectName: BySelector): UiObject2 {
        return device
            .wait(findObject(objectName), waitingTimeOut)
    }

    fun findObject(text: String): UiObject {
        return device.findObject(UiSelector().textContains(text))
    }

    fun pressButton(buttonSelector: BySelector) {
        waitAndFindObject(buttonSelector).click()
    }

    fun checkText(text: String): Boolean {
        return device.wait(hasObject(By.text(text)), waitingTimeOut)
    }

    fun waiting(){
        Screen.idle(waitingTimeOut)
    }

    companion object {
        const val waitingTimeOut = 7000L
    }
}