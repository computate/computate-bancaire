
// PATCH //

function patchUtilisateurSite($formulaireFiltres, $formulaireValeurs, success, error) {
	var filtres = patchUtilisateurSiteFiltres($formulaireFiltres);

	var vals = {};

	var removePk = $formulaireFiltres.find('.removePk').val() === 'true';
	var setPk = removePk ? null : $formulaireValeurs.find('.setPk').val();
	if(removePk || setPk != null && setPk !== '')
		vals['setPk'] = setPk;
	var addPk = $formulaireValeurs.find('.addPk').val();
	if(addPk != null && addPk !== '')
		vals['addPk'] = addPk;
	var removePk = $formulaireValeurs.find('.removePk').val();
	if(removePk != null && removePk !== '')
		vals['removePk'] = removePk;

	var removeCree = $formulaireFiltres.find('.removeCree').val() === 'true';
	var setCree = removeCree ? null : $formulaireValeurs.find('.setCree').val();
	if(removeCree || setCree != null && setCree !== '')
		vals['setCree'] = setCree;
	var addCree = $formulaireValeurs.find('.addCree').val();
	if(addCree != null && addCree !== '')
		vals['addCree'] = addCree;
	var removeCree = $formulaireValeurs.find('.removeCree').val();
	if(removeCree != null && removeCree !== '')
		vals['removeCree'] = removeCree;

	var removeModifie = $formulaireFiltres.find('.removeModifie').val() === 'true';
	var setModifie = removeModifie ? null : $formulaireValeurs.find('.setModifie').val();
	if(removeModifie || setModifie != null && setModifie !== '')
		vals['setModifie'] = setModifie;
	var addModifie = $formulaireValeurs.find('.addModifie').val();
	if(addModifie != null && addModifie !== '')
		vals['addModifie'] = addModifie;
	var removeModifie = $formulaireValeurs.find('.removeModifie').val();
	if(removeModifie != null && removeModifie !== '')
		vals['removeModifie'] = removeModifie;

	var removeUtilisateurId = $formulaireFiltres.find('.removeUtilisateurId').val() === 'true';
	var setUtilisateurId = removeUtilisateurId ? null : $formulaireValeurs.find('.setUtilisateurId').val();
	if(removeUtilisateurId || setUtilisateurId != null && setUtilisateurId !== '')
		vals['setUtilisateurId'] = setUtilisateurId;
	var addUtilisateurId = $formulaireValeurs.find('.addUtilisateurId').val();
	if(addUtilisateurId != null && addUtilisateurId !== '')
		vals['addUtilisateurId'] = addUtilisateurId;
	var removeUtilisateurId = $formulaireValeurs.find('.removeUtilisateurId').val();
	if(removeUtilisateurId != null && removeUtilisateurId !== '')
		vals['removeUtilisateurId'] = removeUtilisateurId;

	var removeVoirArchive = $formulaireFiltres.find('.removeVoirArchive').val() === 'true';
	var setVoirArchive = removeVoirArchive ? null : $formulaireValeurs.find('.setVoirArchive').prop('checked');
	if(removeVoirArchive || setVoirArchive != null && setVoirArchive !== '')
		vals['setVoirArchive'] = setVoirArchive;
	var addVoirArchive = $formulaireValeurs.find('.addVoirArchive').prop('checked');
	if(addVoirArchive != null && addVoirArchive !== '')
		vals['addVoirArchive'] = addVoirArchive;
	var removeVoirArchive = $formulaireValeurs.find('.removeVoirArchive').prop('checked');
	if(removeVoirArchive != null && removeVoirArchive !== '')
		vals['removeVoirArchive'] = removeVoirArchive;

	var removeVoirSupprime = $formulaireFiltres.find('.removeVoirSupprime').val() === 'true';
	var setVoirSupprime = removeVoirSupprime ? null : $formulaireValeurs.find('.setVoirSupprime').prop('checked');
	if(removeVoirSupprime || setVoirSupprime != null && setVoirSupprime !== '')
		vals['setVoirSupprime'] = setVoirSupprime;
	var addVoirSupprime = $formulaireValeurs.find('.addVoirSupprime').prop('checked');
	if(addVoirSupprime != null && addVoirSupprime !== '')
		vals['addVoirSupprime'] = addVoirSupprime;
	var removeVoirSupprime = $formulaireValeurs.find('.removeVoirSupprime').prop('checked');
	if(removeVoirSupprime != null && removeVoirSupprime !== '')
		vals['removeVoirSupprime'] = removeVoirSupprime;

	patchUtilisateurSiteVals(filtres, vals, success, error);
}

function patchUtilisateurSiteFiltres($formulaireFiltres) {
	var filtres = [];

	var filtrePk = $formulaireFiltres.find('.valeurPk').val();
	if(filtrePk != null && filtrePk !== '')
		filtres.push({ name: 'fq', value: 'pk:' + filtrePk });

	var filtreCree = $formulaireFiltres.find('.valeurCree').val();
	if(filtreCree != null && filtreCree !== '')
		filtres.push({ name: 'fq', value: 'cree:' + filtreCree });

	var filtreModifie = $formulaireFiltres.find('.valeurModifie').val();
	if(filtreModifie != null && filtreModifie !== '')
		filtres.push({ name: 'fq', value: 'modifie:' + filtreModifie });

	var filtreUtilisateurId = $formulaireFiltres.find('.valeurUtilisateurId').val();
	if(filtreUtilisateurId != null && filtreUtilisateurId !== '')
		filtres.push({ name: 'fq', value: 'utilisateurId:' + filtreUtilisateurId });

	var filtreVoirArchive = $formulaireFiltres.find('.valeurVoirArchive').prop('checked');
	if(filtreVoirArchive != null && filtreVoirArchive === true)
		filtres.push({ name: 'fq', value: 'voirArchive:' + filtreVoirArchive });

	var filtreVoirSupprime = $formulaireFiltres.find('.valeurVoirSupprime').prop('checked');
	if(filtreVoirSupprime != null && filtreVoirSupprime === true)
		filtres.push({ name: 'fq', value: 'voirSupprime:' + filtreVoirSupprime });

	var filtreId = $formulaireFiltres.find('.valeurId').val();
	if(filtreId != null && filtreId !== '')
		filtres.push({ name: 'fq', value: 'id:' + filtreId });

	var filtreArchive = $formulaireFiltres.find('.valeurArchive').prop('checked');
	if(filtreArchive != null && filtreArchive === true)
		filtres.push({ name: 'fq', value: 'archive:' + filtreArchive });

	var filtreSupprime = $formulaireFiltres.find('.valeurSupprime').prop('checked');
	if(filtreSupprime != null && filtreSupprime === true)
		filtres.push({ name: 'fq', value: 'supprime:' + filtreSupprime });

	var filtreClasseNomCanonique = $formulaireFiltres.find('.valeurClasseNomCanonique').val();
	if(filtreClasseNomCanonique != null && filtreClasseNomCanonique !== '')
		filtres.push({ name: 'fq', value: 'classeNomCanonique:' + filtreClasseNomCanonique });

	var filtreClasseNomSimple = $formulaireFiltres.find('.valeurClasseNomSimple').val();
	if(filtreClasseNomSimple != null && filtreClasseNomSimple !== '')
		filtres.push({ name: 'fq', value: 'classeNomSimple:' + filtreClasseNomSimple });

	var filtreClasseNomsCanoniques = $formulaireFiltres.find('.valeurClasseNomsCanoniques').val();
	if(filtreClasseNomsCanoniques != null && filtreClasseNomsCanoniques !== '')
		filtres.push({ name: 'fq', value: 'classeNomsCanoniques:' + filtreClasseNomsCanoniques });

	var filtreUtilisateurNom = $formulaireFiltres.find('.valeurUtilisateurNom').val();
	if(filtreUtilisateurNom != null && filtreUtilisateurNom !== '')
		filtres.push({ name: 'fq', value: 'utilisateurNom:' + filtreUtilisateurNom });

	var filtreUtilisateurMail = $formulaireFiltres.find('.valeurUtilisateurMail').val();
	if(filtreUtilisateurMail != null && filtreUtilisateurMail !== '')
		filtres.push({ name: 'fq', value: 'utilisateurMail:' + filtreUtilisateurMail });

	var filtreUtilisateurPrenom = $formulaireFiltres.find('.valeurUtilisateurPrenom').val();
	if(filtreUtilisateurPrenom != null && filtreUtilisateurPrenom !== '')
		filtres.push({ name: 'fq', value: 'utilisateurPrenom:' + filtreUtilisateurPrenom });

	var filtreUtilisateurNomFamille = $formulaireFiltres.find('.valeurUtilisateurNomFamille').val();
	if(filtreUtilisateurNomFamille != null && filtreUtilisateurNomFamille !== '')
		filtres.push({ name: 'fq', value: 'utilisateurNomFamille:' + filtreUtilisateurNomFamille });

	var filtreUtilisateurNomComplet = $formulaireFiltres.find('.valeurUtilisateurNomComplet').val();
	if(filtreUtilisateurNomComplet != null && filtreUtilisateurNomComplet !== '')
		filtres.push({ name: 'fq', value: 'utilisateurNomComplet:' + filtreUtilisateurNomComplet });

	var filtreUtilisateurSite = $formulaireFiltres.find('.valeurUtilisateurSite').val();
	if(filtreUtilisateurSite != null && filtreUtilisateurSite !== '')
		filtres.push({ name: 'fq', value: 'utilisateurSite:' + filtreUtilisateurSite });

	var filtreUtilisateurRecevoirCourriels = $formulaireFiltres.find('.valeurUtilisateurRecevoirCourriels').prop('checked');
	if(filtreUtilisateurRecevoirCourriels != null && filtreUtilisateurRecevoirCourriels === true)
		filtres.push({ name: 'fq', value: 'utilisateurRecevoirCourriels:' + filtreUtilisateurRecevoirCourriels });
	return filtres;
}

function patchUtilisateurSiteVal(filtres, v, val, success, error) {
	var vals = {};
	vals[v] = val;
	patchUtilisateurSiteVals(filtres, vals, success, error);
}

function patchUtilisateurSiteVals(filtres, vals, success, error) {
	$.ajax({
		url: '/api/utilisateur?' + $.param(filtres)
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}
