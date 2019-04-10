# -*- coding: utf-8 -*-

import names

def main():
    startBrowser("https://www.google.com.co/")
    setFocus(waitForObject(names.google_q_text))
    typeText(waitForObject(names.google_q_text), "squish IDE")
    clickButton(waitForObject(names.google_btnK_submit))
    test.vp("VP1")
