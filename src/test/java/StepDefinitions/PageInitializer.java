package StepDefinitions;

import Pages.AddEmployeePage;
import Pages.LoginPage;

public class PageInitializer {

    public  static LoginPage login;
    public  static AddEmployeePage addEmployeePage;
    public  static void initializePageObjects()
    {
        login = new LoginPage();
        addEmployeePage= new AddEmployeePage();
    }
}




/*this class will manage the object creation of different page object in our framework.
instead of calling the age object again and again, this class will take care of that
*/