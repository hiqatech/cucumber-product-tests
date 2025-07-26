package common.cucumber;

import common.appium.AppHelp;
import io.cucumber.java.en.Given;
import products.Store.pages.MainPage;

import static common.appium.AppHelp.*;
import static common.setup.Hooks.AssertStep;
import static common.setup.Hooks.setProductEnv;

public class AppSteps {

    @Given("I setup the {string} on {string} for app")
    public static void ISetProductEnvApp(String product,String environment){
        setProductEnv(product, environment);
    }

    @Given("I start the {string} {string} device for {string} app")
    public static void IStartTheDevice(String device,String name, String app){
        AppHelp.startAppDriver("android","Pixel28", "General-store.apk");
    }

    @Given("I select {string} from {string} on app")
    public static void ISelectFromDropdownApp(String text,String element){
        AssertStep(selectDropDown(MainPage.get(element),text) +
                " : " + "I select " + text + " from " + element + " on app");
    }

    @Given("I type {string} into {string} on app")
    public static void ITypeInElementApp(String text,String element){
        AssertStep(typeElement(MainPage.get(element), text) +
                " : " + "I type " + text + " into " + element + " on app");
    }

    @Given("I set {string} radio on app")
    public static void ISetRadioApp(String element){
        AssertStep(setRadio(MainPage.get(element)) +
                " : " + "I set " + element + " radio on app");
    }

    @Given("I tap {string} button on app")
    public static void IClickButtonApp(String element){
        AssertStep(tapButton(MainPage.get(element)) +
                " : " + "I tap " + element + " button on app");
    }





}
