package org.computate.bancaire.enus.transaction;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.enus.cluster.Cluster;
import org.computate.bancaire.enus.account.BankAccount;
import org.computate.bancaire.enus.wrap.Wrap;
import org.computate.bancaire.enus.search.SearchList;
import org.computate.bancaire.enus.transaction.code.TransactionCode;

public class BankTransaction extends BankTransactionGen<Cluster> {

	protected void _transactionKey(Wrap<Long> c) {
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
			l.addFilterQuery("transactionKeys_indexed_longs:" + pk);
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

	protected void _transactionCode(Wrap<String> c) {
	}

	protected void _transactionCodeSearch(SearchList<TransactionCode> l) {
		if(transactionCode == null) {
			l.setQuery(null);
		}
		else {
			l.setQuery("*:*");
			l.addFilterQuery("transactionCode_indexed_string:" + transactionCode);
			l.setC(TransactionCode.class);
			l.setStore(true);
		}
	}

	protected void _transactionCodeObject_(Wrap<TransactionCode> c) {
		if(transactionCodeSearch.size() > 0) {
			c.o(transactionCodeSearch.get(0));
		}
	}

	protected void _transactionCodeCompleteName(Wrap<String> c) {
		if(transactionCodeObject_ != null)
			c.o(transactionCodeObject_.getTransactionCodeDisplayName());
	}

	protected void _transactionReferenceId(Wrap<String> c) {
	}

	protected void _transactionAmount(Wrap<BigDecimal> c) {
	}

	protected void _transactionDateTime(Wrap<ZonedDateTime> c) {
	}

	protected void _transactionDate(Wrap<LocalDate> c) {
		if(transactionDateTime != null) {
			c.o(ZonedDateTime.ofInstant(transactionDateTime.toInstant(), ZoneId.of(siteRequest_.getSiteConfig_().getSiteZone())).toLocalDate());
		}
	}

	protected void _transactionFee(Wrap<Boolean> c) {
		c.o(false);
	}

	protected void _transactionDisplayName(Wrap<String> c) {}

	protected void _transactionCompleteName(Wrap<String> c) {
		String o = "transaction";

		if(transactionReferenceId != null && accountNumber != null)
			o = String.format("transaction %s of account %s", transactionReferenceId, accountNumber);
		else if(transactionReferenceId != null)
			o = String.format("transaction %s", transactionReferenceId);
		if(transactionReferenceId != null && transactionCode != null && transactionDate != null && transactionAmount != null)
			o = String.format("transaction %s %s %s of account %s", transactionReferenceId, accountNumber);
		if(accountNumber != null)
			o = String.format("transaction of account %s", accountNumber);

		c.o(o);
	}

	protected void _transactionId(Wrap<String> c) {
		if(transactionCompleteName != null) {
			String s = Normalizer.normalize(transactionCompleteName, Normalizer.Form.NFD);
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
		if(transactionId != null) {
			String o = siteRequest_.getSiteConfig_().getSiteBaseUrl() + "/transaction/" + transactionId;
			c.o(o);
		}
	}

	protected void _objectSuggest(Wrap<String> c) { 
		c.o(transactionCompleteName);
	}

	@Override()
	protected void  _classCanonicalNames(List<String> l) {
		l.add(TransactionCode.class.getCanonicalName());
		super._classCanonicalNames(l);
	}
}
