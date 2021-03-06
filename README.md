# SigmaDialog
SigmaDialog, to make it easier for developers to create smart dialogs

Functionality provided in the library:
* ConfirmDialog
* InformationDialog

## Installation ##
Add it in your root build.gradle at the end of repositories:
    
     allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
     }

Add the dependency

    implementation 'com.github.divisi-mobile-POROS:SigmaDialog:1.0.0'

## Usage
ConfirmDialog:

     ConfirmDialog.newInstance(this)
                .setTitle("Title of information dialog")
                .setSubTitle("Subtitle of information dialog")
                .setBundle(bundle)
                .build()
                .show(getSupportFragmentManager(), InformationDialog.TAG);

InformationDialog:

     InformationDialog.newInstance(this)
                .setTitle("Title of information dialog")
                .setSubTitle("Subtitle of information dialog")
                .setBundle(bundle)
                .build()
                .show(getSupportFragmentManager(), InformationDialog.TAG);

Then don't forget to implement `SigmaDialog.ConfirmDialogListener` to your Activity according to what dialog you use

## Sample App
You can see the sample app in `SigmaDialog/app`

## License

    The MIT License (MIT)

    Copyright (c) 2014 Pedant(http://pedant.cn)

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
