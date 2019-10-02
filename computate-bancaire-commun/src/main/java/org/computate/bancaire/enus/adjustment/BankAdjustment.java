package org.computate.bancaire.enus.adjustment;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.enus.cluster.Cluster;
import org.computate.bancaire.enus.account.BankAccount;
import org.computate.bancaire.enus.wrap.Wrap;
import org.computate.bancaire.enus.search.SearchList;
import org.computate.bancaire.enus.transaction.BankTransaction;

public class BankAdjustment extends BankAdjustmentGen<Cluster> {

	protected void _adjustmentKey(Wrap<Long> c) {
		c.o(pk);
	}

	protected void _accountKey(Wrap<Long> c) {
	}

	protected void _accountSearch(SearchList<BankAccount> l) {
		if(pk == null) {
			l.setQuery(null);
		}
		else {
			l.setQuery("*:*");
			l.addFilterQuery("adjustmentKeys_indexed_longs:" + pk);
			l.setC(BankAccount.class);
			l.setStore(true);
		}
	}

	protected void _account_(Wrap<BankAccount> c) {
		if(accountSearch.size() > 0) {
			c.o(accountSearch.get(0));
		}
	}

	protected void _accountCompleteName(Wrap<String> c) {
		if(account_ != null)
			c.o((String)account_.getAccountCompleteName());
	}

	protected void _accountNumber(Wrap<String> c) {
		if(account_ != null)
			c.o((String)account_.getAccountNumber());
	}

	protected void _transactionKey(Wrap<Long> c) {
	}

	protected void _transactionSearch(SearchList<BankTransaction> l) {
		if(pk == null) {
			l.setQuery(null);
		}
		else {
			l.setQuery("*:*");
			l.addFilterQuery("adjustmentKeys_indexed_longs:" + pk);
			l.setC(BankTransaction.class);
			l.setStore(true);
		}
	}

	protected void _transaction_(Wrap<BankTransaction> c) {
		if(transactionSearch.size() > 0) {
			c.o(transactionSearch.get(0));
		}
	}

	protected void _transactionReferenceId(Wrap<String> c) {
		if(transaction_ != null)
			c.o(transaction_.getTransactionReferenceId());
	}

	protected void _transactionCode(Wrap<String> c) {
		if(transaction_ != null)
			c.o(transaction_.getTransactionCode());
	}

	protected void _transactionAmount(Wrap<BigDecimal> c) {
		if(transaction_ != null)
			c.o(transaction_.getTransactionAmount());
	}

	protected void _transactionDateTime(Wrap<ZonedDateTime> c) {
		if(transaction_ != null)
			c.o(transaction_.getTransactionDateTime());
	}

	protected void _transactionDate(Wrap<LocalDate> c) {
		if(transaction_ != null)
			c.o(transaction_.getTransactionDate());
	}

	protected void _transactionFee(Wrap<Boolean> c) {
		if(transaction_ != null)
			c.o(transaction_.getTransactionFee());
	}

	protected void _agentAreas(List<String> l) {
	}

	protected void _agentRoles(List<String> l) {
	}

	protected void _agentOverride(Wrap<Boolean> c) {
		c.o(false);
	}

	protected void _eligibleEntitlement(Wrap<Boolean> c) {
		c.o(false);
	}

	protected void _partnerName(Wrap<String> c) {
	}

	protected void _adjustmentDisplayName(Wrap<String> c) {}

	protected void _adjustmentCompleteName(Wrap<String> c) {
		String o = "ajustement";

		if(transactionReferenceId != null && accountNumber != null)
			o = String.format("ajustement %s of account %s", transactionReferenceId, accountNumber);
		else if(transactionReferenceId != null)
			o = String.format("ajustement %s", transactionReferenceId);
		if(transactionReferenceId != null && transactionCode != null && transactionDate != null && transactionAmount != null)
			o = String.format("ajustement %s %s %s of account %s", transactionReferenceId, accountNumber);
		if(accountNumber != null)
			o = String.format("ajustement of account %s", accountNumber);

		c.o(o);
	}

	protected void _adjustmentId(Wrap<String> c) {
		if(adjustmentCompleteName != null) {
			String s = Normalizer.normalize(adjustmentCompleteName, Normalizer.Form.NFD);
			s = StringUtils.lowerCase(s);
			s = StringUtils.trim(s);
			s = StringUtils.replacePattern(s, "\\s{1,}", "-");
			s = StringUtils.replacePattern(s, "[^\\w-]", "");
			s = StringUtils.replacePattern(s, "-{2,}", "-");
			c.o(s);
		}
		else if(pk != null){
			c.o(pk.toString());
		}
	}

	protected void _pageUrl(Wrap<String> c) {
		if(adjustmentId != null) {
			String o = siteRequest_.getSiteConfig_().getSiteBaseUrl() + "/ajustement/" + adjustmentId;
			c.o(o);
		}
	}

	protected void _objectSuggest(Wrap<String> c) { 
		c.o(adjustmentCompleteName);
	}

	@Override()
	protected void  _classCanonicalNames(List<String> l) {
		l.add(BankAdjustment.class.getCanonicalName());
		super._classCanonicalNames(l);
	}
}
