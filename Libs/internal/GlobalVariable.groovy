package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object G_AndroidApp
     
    /**
     * <p></p>
     */
    public static Object G_Timeout_XShort
     
    /**
     * <p></p>
     */
    public static Object G_Timeout_Short
     
    /**
     * <p></p>
     */
    public static Object G_Timeout_Medium
     
    /**
     * <p></p>
     */
    public static Object G_Timeout_Long
     
    /**
     * <p></p>
     */
    public static Object G_Timeout_XLong
     
    /**
     * <p></p>
     */
    public static Object serverURLstr
     
    /**
     * <p></p>
     */
    public static Object runAsBatch
     
    /**
     * <p></p>
     */
    public static Object changeTest
     
    /**
     * <p></p>
     */
    public static Object serverURL
     
    /**
     * <p></p>
     */
    public static Object eyes
     
    /**
     * <p></p>
     */
    public static Object viewportSizePortraitWidth
     
    /**
     * <p></p>
     */
    public static Object viewportSizePortraitHeight
     
    /**
     * <p></p>
     */
    public static Object viewportSizeLandscapeWidth
     
    /**
     * <p></p>
     */
    public static Object viewportSizeLandscapeHeight
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            G_AndroidApp = selectedVariables['G_AndroidApp']
            G_Timeout_XShort = selectedVariables['G_Timeout_XShort']
            G_Timeout_Short = selectedVariables['G_Timeout_Short']
            G_Timeout_Medium = selectedVariables['G_Timeout_Medium']
            G_Timeout_Long = selectedVariables['G_Timeout_Long']
            G_Timeout_XLong = selectedVariables['G_Timeout_XLong']
            serverURLstr = selectedVariables['serverURLstr']
            runAsBatch = selectedVariables['runAsBatch']
            changeTest = selectedVariables['changeTest']
            serverURL = selectedVariables['serverURL']
            eyes = selectedVariables['eyes']
            viewportSizePortraitWidth = selectedVariables['viewportSizePortraitWidth']
            viewportSizePortraitHeight = selectedVariables['viewportSizePortraitHeight']
            viewportSizeLandscapeWidth = selectedVariables['viewportSizeLandscapeWidth']
            viewportSizeLandscapeHeight = selectedVariables['viewportSizeLandscapeHeight']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
