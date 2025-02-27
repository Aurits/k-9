package com.fsck.k9.account

import com.fsck.k9.Account
import com.fsck.k9.AccountRemovedListener
import com.fsck.k9.AccountsChangeListener
import com.fsck.k9.preferences.AccountManager
import kotlinx.coroutines.flow.Flow

class FakeAccountManager(
    private val accounts: Map<String, Account> = emptyMap(),
) : AccountManager {

    override fun getAccountsFlow(): Flow<List<Account>> {
        TODO("Not yet implemented")
    }

    override fun getAccount(accountUuid: String): Account? = accounts[accountUuid]

    override fun getAccountFlow(accountUuid: String): Flow<Account> {
        TODO("Not yet implemented")
    }

    override fun addAccountRemovedListener(listener: AccountRemovedListener) {
        TODO("Not yet implemented")
    }

    override fun moveAccount(account: Account, newPosition: Int) {
        TODO("Not yet implemented")
    }

    override fun addOnAccountsChangeListener(accountsChangeListener: AccountsChangeListener) {
        TODO("Not yet implemented")
    }

    override fun removeOnAccountsChangeListener(accountsChangeListener: AccountsChangeListener) {
        TODO("Not yet implemented")
    }

    override fun saveAccount(account: Account) {
        TODO("Not yet implemented")
    }
}
