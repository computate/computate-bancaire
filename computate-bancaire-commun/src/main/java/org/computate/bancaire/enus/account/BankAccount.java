package org.computate.bancaire.enus.account;

import java.text.Normalizer;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.enus.cluster.Cluster;
import org.computate.bancaire.enus.wrap.Wrap;

public class BankAccount extends BankAccountGen<Cluster> {

	protected void _accountKey(Wrap<Long> c) {
		c.o(pk);
	}

	protected void _yearKeys(List<Long> o) {}

	protected void _accountNumber(Wrap<String> c) {
	}

	protected void _accountPhoneNumber(Wrap<String> c) {
	}

	protected void _accountAdministratorName(Wrap<String> c) {
	}

	protected void _accountLocation(Wrap<String> c) {
	}

	protected void _accountAddress(Wrap<String> c) {
	}

	protected void _objectSuggestWeight(Wrap<Double> c) {
		c.o(1D);
	}

	protected void _objectSuggest(Wrap<String> c) { 
		c.o(accountNumber);
	}

	protected void _accountShortName(Wrap<String> c) {
		if(accountLocation != null)
			c.o(accountLocation);
		else 
			c.o(accountNumber);
	}

	protected void _accountCompleteName(Wrap<String> c) {
		if(accountLocation != null)
			c.o(String.format("%s at %s", accountNumber, accountLocation));
		else 
			c.o(accountNumber);
	}

	protected void _accountId(Wrap<String> c) {
		if(accountNumber != null) {
			String s = Normalizer.normalize(accountNumber, Normalizer.Form.NFD);
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
		if(accountId != null) {
			String o = siteRequest_.getSiteConfig_().getSiteBaseUrl() + "/account/" + accountId;
			c.o(o);
		}
	}

	protected void _pageH1(Wrap<String> c) {
		c.o("Account: " + accountNumber);
	}

	public void  htmlBody() {
		super.htmlBody();
	}

	@Override()
	protected void  _classCanonicalNames(List<String> l) {
		l.add(BankAccount.class.getCanonicalName());
		super._classCanonicalNames(l);
	}
}
