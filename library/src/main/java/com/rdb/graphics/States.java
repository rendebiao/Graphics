package com.rdb.graphics;

public class States {

    int[] state;
    boolean enable, pressed, checked, selected, focused, checkable,
            activated, windowFocused, active, single, first, middle, last;

    public States() {

    }

    public States(boolean enable) {
        this.enable = enable;
    }

    public States(int[] state) {
        onStateChange(state);
    }

    public void onStateChange(int[] state) {
        reset();
        for (int i = 0, j = state != null ? state.length : 0; i < j; i++) {
            if (state[i] == android.R.attr.state_enabled) {
                enable = true;
            } else if (state[i] == android.R.attr.state_pressed) {
                pressed = true;
            } else if (state[i] == android.R.attr.state_checked) {
                checked = true;
            } else if (state[i] == android.R.attr.state_selected) {
                selected = true;
            } else if (state[i] == android.R.attr.state_focused) {
                focused = true;
            } else if (state[i] == android.R.attr.state_checkable) {
                checkable = true;
            } else if (state[i] == android.R.attr.state_activated) {
                activated = true;
            } else if (state[i] == android.R.attr.state_window_focused) {
                windowFocused = true;
            } else if (state[i] == android.R.attr.state_active) {
                active = true;
            } else if (state[i] == android.R.attr.state_single) {
                single = true;
            } else if (state[i] == android.R.attr.state_first) {
                first = true;
            } else if (state[i] == android.R.attr.state_middle) {
                middle = true;
            } else if (state[i] == android.R.attr.state_last) {
                last = true;
            }
        }
        this.state = state;
    }

    public void reset() {
        enable = false;
        pressed = false;
        checked = false;
        selected = false;
        focused = false;
        checkable = false;
        activated = false;
        windowFocused = false;
        active = false;
        single = false;
        first = false;
        middle = false;
        last = false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof States)) {
            return false;
        }
        States s = (States) o;
        return enable == s.enable && pressed == s.pressed && checked == s.checked && selected == s.selected && focused == s.focused && checkable == s.checkable
                && activated == s.activated && windowFocused == s.windowFocused && active == s.active && single == s.single && first == s.first && middle == s.middle && last == s.last;
    }

    @Override
    public String toString() {
        return "ViewState enable = " + enable + " pressed = " + pressed + " checked = " + checked + " selected = " + selected + " focused = " + focused + " checkable = " + checkable
                + " activated = " + activated + " windowFocused = " + windowFocused + " active = " + active + " single = " + single + " first = " + first + " first = " + middle + " last = " + last;
    }

    public int[] getState() {
        return state;
    }

    public boolean isEnable() {
        return enable;
    }

    public boolean isPressed() {
        return pressed;
    }

    public boolean isChecked() {
        return checked;
    }

    public boolean isSelected() {
        return selected;
    }

    public boolean isFocused() {
        return focused;
    }

    public boolean isCheckable() {
        return checkable;
    }

    public boolean isActivated() {
        return activated;
    }

    public boolean isWindowFocused() {
        return windowFocused;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isSingle() {
        return single;
    }

    public boolean isFirst() {
        return first;
    }

    public boolean isMiddle() {
        return middle;
    }

    public boolean isLast() {
        return last;
    }
}
