
// PATCH //

function patchSiteUser($formFilters, $formValues, success, error) {
	var filters = patchSiteUserFilters($formFilters);

	var vals = {};

	var removePk = $formFilters.find('.removePk').val() === 'true';
	var setPk = removePk ? null : $formValues.find('.setPk').val();
	if(removePk || setPk != null && setPk !== '')
		vals['setPk'] = setPk;
	var addPk = $formValues.find('.addPk').val();
	if(addPk != null && addPk !== '')
		vals['addPk'] = addPk;
	var removePk = $formValues.find('.removePk').val();
	if(removePk != null && removePk !== '')
		vals['removePk'] = removePk;

	var removeCreated = $formFilters.find('.removeCreated').val() === 'true';
	var setCreated = removeCreated ? null : $formValues.find('.setCreated').val();
	if(removeCreated || setCreated != null && setCreated !== '')
		vals['setCreated'] = setCreated;
	var addCreated = $formValues.find('.addCreated').val();
	if(addCreated != null && addCreated !== '')
		vals['addCreated'] = addCreated;
	var removeCreated = $formValues.find('.removeCreated').val();
	if(removeCreated != null && removeCreated !== '')
		vals['removeCreated'] = removeCreated;

	var removeModified = $formFilters.find('.removeModified').val() === 'true';
	var setModified = removeModified ? null : $formValues.find('.setModified').val();
	if(removeModified || setModified != null && setModified !== '')
		vals['setModified'] = setModified;
	var addModified = $formValues.find('.addModified').val();
	if(addModified != null && addModified !== '')
		vals['addModified'] = addModified;
	var removeModified = $formValues.find('.removeModified').val();
	if(removeModified != null && removeModified !== '')
		vals['removeModified'] = removeModified;

	var removeUserId = $formFilters.find('.removeUserId').val() === 'true';
	var setUserId = removeUserId ? null : $formValues.find('.setUserId').val();
	if(removeUserId || setUserId != null && setUserId !== '')
		vals['setUserId'] = setUserId;
	var addUserId = $formValues.find('.addUserId').val();
	if(addUserId != null && addUserId !== '')
		vals['addUserId'] = addUserId;
	var removeUserId = $formValues.find('.removeUserId').val();
	if(removeUserId != null && removeUserId !== '')
		vals['removeUserId'] = removeUserId;

	var removeSeeArchived = $formFilters.find('.removeSeeArchived').val() === 'true';
	var setSeeArchived = removeSeeArchived ? null : $formValues.find('.setSeeArchived').prop('checked');
	if(removeSeeArchived || setSeeArchived != null && setSeeArchived !== '')
		vals['setSeeArchived'] = setSeeArchived;
	var addSeeArchived = $formValues.find('.addSeeArchived').prop('checked');
	if(addSeeArchived != null && addSeeArchived !== '')
		vals['addSeeArchived'] = addSeeArchived;
	var removeSeeArchived = $formValues.find('.removeSeeArchived').prop('checked');
	if(removeSeeArchived != null && removeSeeArchived !== '')
		vals['removeSeeArchived'] = removeSeeArchived;

	var removeSeeDeleted = $formFilters.find('.removeSeeDeleted').val() === 'true';
	var setSeeDeleted = removeSeeDeleted ? null : $formValues.find('.setSeeDeleted').prop('checked');
	if(removeSeeDeleted || setSeeDeleted != null && setSeeDeleted !== '')
		vals['setSeeDeleted'] = setSeeDeleted;
	var addSeeDeleted = $formValues.find('.addSeeDeleted').prop('checked');
	if(addSeeDeleted != null && addSeeDeleted !== '')
		vals['addSeeDeleted'] = addSeeDeleted;
	var removeSeeDeleted = $formValues.find('.removeSeeDeleted').prop('checked');
	if(removeSeeDeleted != null && removeSeeDeleted !== '')
		vals['removeSeeDeleted'] = removeSeeDeleted;

	patchSiteUserVals(filters, vals, success, error);
}

function patchSiteUserFilters($formFilters) {
	var filters = [];

	var filterPk = $formFilters.find('.valuePk').val();
	if(filterPk != null && filterPk !== '')
		filters.push({ name: 'fq', value: 'pk:' + filterPk });

	var filterCreated = $formFilters.find('.valueCreated').val();
	if(filterCreated != null && filterCreated !== '')
		filters.push({ name: 'fq', value: 'created:' + filterCreated });

	var filterModified = $formFilters.find('.valueModified').val();
	if(filterModified != null && filterModified !== '')
		filters.push({ name: 'fq', value: 'modified:' + filterModified });

	var filterUserId = $formFilters.find('.valueUserId').val();
	if(filterUserId != null && filterUserId !== '')
		filters.push({ name: 'fq', value: 'userId:' + filterUserId });

	var filterSeeArchived = $formFilters.find('.valueSeeArchived').prop('checked');
	if(filterSeeArchived != null && filterSeeArchived === true)
		filters.push({ name: 'fq', value: 'seeArchived:' + filterSeeArchived });

	var filterSeeDeleted = $formFilters.find('.valueSeeDeleted').prop('checked');
	if(filterSeeDeleted != null && filterSeeDeleted === true)
		filters.push({ name: 'fq', value: 'seeDeleted:' + filterSeeDeleted });

	var filterId = $formFilters.find('.valueId').val();
	if(filterId != null && filterId !== '')
		filters.push({ name: 'fq', value: 'id:' + filterId });

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterClassCanonicalName = $formFilters.find('.valueClassCanonicalName').val();
	if(filterClassCanonicalName != null && filterClassCanonicalName !== '')
		filters.push({ name: 'fq', value: 'classCanonicalName:' + filterClassCanonicalName });

	var filterClassSimpleName = $formFilters.find('.valueClassSimpleName').val();
	if(filterClassSimpleName != null && filterClassSimpleName !== '')
		filters.push({ name: 'fq', value: 'classSimpleName:' + filterClassSimpleName });

	var filterClassCanonicalNames = $formFilters.find('.valueClassCanonicalNames').val();
	if(filterClassCanonicalNames != null && filterClassCanonicalNames !== '')
		filters.push({ name: 'fq', value: 'classCanonicalNames:' + filterClassCanonicalNames });

	var filterUserName = $formFilters.find('.valueUserName').val();
	if(filterUserName != null && filterUserName !== '')
		filters.push({ name: 'fq', value: 'userName:' + filterUserName });

	var filterUserEmail = $formFilters.find('.valueUserEmail').val();
	if(filterUserEmail != null && filterUserEmail !== '')
		filters.push({ name: 'fq', value: 'userEmail:' + filterUserEmail });

	var filterUserFirstName = $formFilters.find('.valueUserFirstName').val();
	if(filterUserFirstName != null && filterUserFirstName !== '')
		filters.push({ name: 'fq', value: 'userFirstName:' + filterUserFirstName });

	var filterUserLastName = $formFilters.find('.valueUserLastName').val();
	if(filterUserLastName != null && filterUserLastName !== '')
		filters.push({ name: 'fq', value: 'userLastName:' + filterUserLastName });

	var filterUserFullName = $formFilters.find('.valueUserFullName').val();
	if(filterUserFullName != null && filterUserFullName !== '')
		filters.push({ name: 'fq', value: 'userFullName:' + filterUserFullName });

	var filterUserSite = $formFilters.find('.valueUserSite').val();
	if(filterUserSite != null && filterUserSite !== '')
		filters.push({ name: 'fq', value: 'userSite:' + filterUserSite });

	var filterUserReceiveEmails = $formFilters.find('.valueUserReceiveEmails').prop('checked');
	if(filterUserReceiveEmails != null && filterUserReceiveEmails === true)
		filters.push({ name: 'fq', value: 'userReceiveEmails:' + filterUserReceiveEmails });
	return filters;
}

function patchSiteUserVal(filters, v, val, success, error) {
	var vals = {};
	vals[v] = val;
	patchSiteUserVals(filters, vals, success, error);
}

function patchSiteUserVals(filters, vals, success, error) {
	$.ajax({
		url: '/api/user?' + $.param(filters)
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}
