package org.rudn.sdkritskiy.testproject;

public class Sender {
    static String _message;

    public static void SetMessage(String message)
    {
        _message = message;
    }

    public static String GetMessage()
    {
        return _message;
    }
}
