import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Tests extends BaseTest{
    //TODO написала комментарии, где меня что-то смутило. В целом, очень хороший тест.
    // Видно, что не успели дописать. Не хватает комментариев, не доделана логика.
    // Зато успели создать много страниц, подстраниц и ExistChecker. Однако, мне кажется, легче,
    // чтоб методы там проверяли на наличие элементов через Assert, а не возвращали boolean.
    // Также хочу отметить хорошую работу с коллекциями, потоками и строками.

    String username = ""; //bot username
    String password = ""; //bot passord
    // TODO не уверена, что нужно выносить поле класса
    String groupHREF = null;

    List<CardElement> groupList;


    @Test
    public void start(){

        UserPage userPage = new LoginPage(this.driver).logIn(username, password);
        GroupPage group = userPage.moveToGroups();

        group.selectCategory(); //need to wait



        groupList = group.getGroupsList();

        Assert.assertTrue("Cards not found", groupList.size() != 0);

        //TODO эта проверка лучше смотрелась бы в GroupPage
        for(CardElement card : groupList){
            Assert.assertTrue("Image not loaded", card.imgExist(driver));
        }


        //Попытка вступить в группу, для дальнейшей проверки, что группа появилась на странице "мои группы"
        //нужен униукальный идентификатор, например - ссылка на группу.
        //Нужно добавить проверку на то, что бот не состоит в данной группе
        groupHREF = groupList.get(0).addGroup();


        Assert.assertTrue("Group not in My Groups",
                group.selectMyGroups()
                        .getMyGroupsSubpage()
                        .findGroupByHref(groupHREF));


    //TODO Наверное, дебажили и не убрали слип?

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //TODO лучше вынести в BaseTest
    @After
    public void close(){
        this.driverExit();
    }

}
