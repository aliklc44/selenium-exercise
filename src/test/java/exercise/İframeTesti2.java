package exercise;

import org.junit.Test;

public class İframeTesti2 extends TasteBase{

    /*
    ● Bir class olusturun: IframeTest02
1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
2) sayfadaki iframe sayısını bulunuz.
3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
4) ilk iframe'den çıkıp ana sayfaya dönünüz
5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
tıklayınız
     */

    @Test
    public void test01() {
        driver.get("https://demo.guru99.com/test/guru99home/");

    }
}
