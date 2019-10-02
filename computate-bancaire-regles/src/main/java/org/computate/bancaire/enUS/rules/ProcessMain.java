package org.computate.bancaire.enUS.rules;

import org.computate.bancaire.enus.adjustment.BankAdjustment;
import org.computate.bancaire.enus.contexte.SiteContextEnUS;
import org.computate.bancaire.enus.request.SiteRequestEnUS;
import org.computate.bancaire.enus.transaction.BankTransaction;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class ProcessMain {

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		KieSession kSession = kContainer.newKieSession("computate-bancaire-regles");

		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
		SiteContextEnUS siteContext = new SiteContextEnUS();
		siteRequest.setSiteContext_(siteContext);
		siteRequest.initDeepSiteRequestEnUS();
		siteContext.getSiteConfig().setConfigPath("/usr/local/src/computate-bancaire/computate-bancaire-commun/config/computate-bancaire-commun-enUS.config");
		siteContext.initDeepSiteContextEnUS();
		siteRequest.setSiteConfig_(siteContext.getSiteConfig());

		{
			final BankTransaction transaction = new BankTransaction() {{
				setTransactionFee(true);
			}};
			transaction.initDeepBankTransaction(siteRequest);
	
			final BankAdjustment adjustment = new BankAdjustment() {{
				setTransaction_(transaction);
				addAgentAreas("Not");
				addAgentRoles("Not Executive");
				setPartnerName("Scrooge and Marley");
			}};
			adjustment.initDeepBankAdjustment(siteRequest);
	
			kSession.insert(adjustment);
			kSession.fireAllRules();
			System.out.println(adjustment.toString());
		}

		{
			final BankTransaction transaction = new BankTransaction() {{
				setTransactionFee(true);
			}};
			transaction.initDeepBankTransaction(siteRequest);
	
			final BankAdjustment adjustment = new BankAdjustment() {{
				setTransaction_(transaction);
				addAgentAreas("Operations");
				addAgentRoles("Operations Executive");
				setPartnerName("Scrooge and Marley");
			}};
			adjustment.initDeepBankAdjustment(siteRequest);
	
			kSession.insert(adjustment);
			kSession.fireAllRules();
			System.out.println(adjustment.toString());
		}
	}
}