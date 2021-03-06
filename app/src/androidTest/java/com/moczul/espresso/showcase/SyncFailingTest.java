package com.moczul.espresso.showcase;

import android.os.Build;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.moczul.espresso.showcase.actions.CustomActions.text;
import static com.moczul.espresso.showcase.matchers.CustomMatchers.hasText;

@RunWith(AndroidJUnit4.class)
public class SyncFailingTest {

    @Rule
    public ActivityTestRule<MainActivity> mRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void failingTest() {
        onView(withId(R.id.text_input)).perform(text("ADG-Poznan"));
        onView(withId(R.id.action)).perform(click());

        onView(withId(R.id.output)).check(matches(hasText("ADG-Poznan")));
    }
}
