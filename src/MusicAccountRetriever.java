

import utilities.AmazonMusicAccount;
import utilities.MusicAccountService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MusicAccountRetriever {

    private MusicAccountService accountService;

    /**
     * Constructor for MusicAccountRetriever.
     */
    public MusicAccountRetriever() {
        accountService = new MusicAccountService();
    }

    public MusicAccountService getAccountService() {
        return accountService;
    }

    /**
     * Retrieves an AmazonMusicAccount with the requested account ID. Returns the result as a Future.
     * PARTICIPANTS: Complete this class declaration and implementation.
     * @param accountID Account ID for requested account.
     * @return A Future result of the AmazonMusicAccount.
     */
    public Future<AmazonMusicAccount> retrieveAccount(String accountID) {
        ExecutorService accountExecutor = Executors.newCachedThreadPool();

        // Create the ImportAccountTask
        ImportAccountTask task = new ImportAccountTask(accountService, accountID);

        // Submit the task and get the Future
        Future<AmazonMusicAccount> result = accountExecutor.submit(task); //null;
        accountExecutor.shutdown();

        accountExecutor.shutdown();

        return result;
    }
}
