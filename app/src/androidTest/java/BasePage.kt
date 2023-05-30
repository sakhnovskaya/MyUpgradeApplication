import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until.findObject
import androidx.test.uiautomator.Until.hasObject

open class BasePage {

    val device: UiDevice =
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    fun pressButton(buttonSelector: BySelector) {
        device
            .wait(findObject(buttonSelector), waitingTimeOut)
            .click()
    }

    fun checkText(text: String) {
        assert(
            device
                .wait(hasObject(By.text(text)), waitingTimeOut)
        )
    }

    companion object {
        const val waitingTimeOut = 5000L
    }
}