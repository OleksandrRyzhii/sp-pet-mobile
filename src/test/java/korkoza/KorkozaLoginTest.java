package korkoza;

import com.sp.pet.mobile.automation.screens.android.SignInScreen;
import com.sp.pet.mobile.automation.util.runners.AndroidTestRunner;
import org.junit.jupiter.api.Test;

import static com.sp.pet.mobile.automation.repo.UserRepo.getUser;
import static org.assertj.core.api.Assertions.assertThat;

public class KorkozaLoginTest extends AndroidTestRunner {

    @Test
    public void verifySigningInWithIncorrectCredentials() {
        var signInScreen = new SignInScreen();
        var user = getUser();

        signInScreen.signIn(user);
        System.out.println(signInScreen.getErrorMessage());
        assertThat(signInScreen.getErrorMessage())
                .as("Error message should be correct")
                .isEqualTo("Invalid email or password");
    }
}