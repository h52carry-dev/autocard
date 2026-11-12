package net.classcard.autocard

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

/**
 * Android accessibility integration point.
 * This first build deliberately does not auto-answer or auto-complete lessons.
 * User-directed study assistance can be added here after on-device validation.
 */
class StudyAccessibilityService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Observe page/window changes only; no unattended clicks or answer submission.
    }

    override fun onInterrupt() = Unit
}
