package espresso.test.project

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun changeTextByClick() {

        Espresso.onView(withId(R.id.textInput))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))

        Espresso.onView(withId(R.id.clickMeTenderBtn)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.textInput))
            .check(ViewAssertions.matches(ViewMatchers.withText("You clicked me!")))

    }

    @Test
    fun changeTextByClick_ifTextIsExist() {
        Espresso.onView(withId(R.id.textInput)).perform(ViewActions.typeText("Some new text!"))

        Espresso.closeSoftKeyboard();

        Espresso.onView(withId(R.id.textInput))
            .check(ViewAssertions.matches(ViewMatchers.withText("Some new text!")))

        Espresso.onView(withId(R.id.clickMeTenderBtn)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.textInput))
            .check(ViewAssertions.matches(ViewMatchers.withText("You clicked me!")))

    }
}