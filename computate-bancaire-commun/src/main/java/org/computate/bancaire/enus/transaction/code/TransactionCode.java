package org.computate.bancaire.enus.transaction.code;

import java.text.Normalizer;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.enus.cluster.Cluster;
import org.computate.bancaire.enus.wrap.Wrap;

public class TransactionCode extends TransactionCodeGen<Cluster> {

	protected void _transactionCodeKey(Wrap<Long> c) {
		c.o(pk);
	}

	protected void _transactionCode(Wrap<String> c) {}

	protected void _transactionCodeDisplayName(Wrap<String> c) {}

	protected void _transactionCodeCompleteName(Wrap<String> c) {
		String o = "transaction code";

		if(transactionCode != null && transactionCodeDisplayName != null)
			o = String.format("%s %s", transactionCode, transactionCodeDisplayName);
		else if(transactionCode != null)
			o = String.format("%s", transactionCode);
		else if(transactionCodeDisplayName != null)
			o = String.format("%s", transactionCodeDisplayName);

		c.o(o);
	}

	protected void _transactionCodeId(Wrap<String> c) {
		if(transactionCodeCompleteName != null) {
			String s = Normalizer.normalize(transactionCodeCompleteName, Normalizer.Form.NFD);
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
		if(transactionCodeId != null) {
			String o = siteRequest_.getSiteConfig_().getSiteBaseUrl() + "/transaction-code/" + transactionCodeId;
			c.o(o);
		}
	}

	protected void _objectSuggest(Wrap<String> c) { 
		c.o(transactionCodeCompleteName);
	}

	@Override()
	protected void  _classCanonicalNames(List<String> l) {
		l.add(TransactionCode.class.getCanonicalName());
		super._classCanonicalNames(l);
	}
}
