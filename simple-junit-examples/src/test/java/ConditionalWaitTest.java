import static org.junit.Assert.assertTrue;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import org.junit.Test;

public class ConditionalWaitTest {

    final EmailSender emailSender = new EmailSender();

    @Test
    public void test() throws Exception {
        emailSender.sendEmail();
        assertTrue(emailSender.isEmailSent());
    }


    public static class EmailSender {

        private boolean emailSent = false;

        public void sendEmail() throws InterruptedException {
            new CompletableFuture<Void>()
            ((Runnable) () -> {
                try {
                    System.out.println("Connecting to email sever...");
                    Thread.sleep(5000);
                    System.out.println("Connected to email sever.");
                    System.out.println("Sending email...");
                    Thread.sleep(500);
                    emailSent = true;
                    System.out.println("Successfully send email.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).run();
        }

        public boolean isEmailSent() {
            return emailSent;
        }
    }

}
