
// POST //

function postBankTransaction($formValues) {
	var vals = {};

	var valuePk = $formValues.find('.valuePk').val();
	if(valuePk != null && valuePk !== '')
		vals['pk'] = valuePk;

	var valueCreated = $formValues.find('.valueCreated').val();
	if(valueCreated != null && valueCreated !== '')
		vals['created'] = valueCreated;

	var valueModified = $formValues.find('.valueModified').val();
	if(valueModified != null && valueModified !== '')
		vals['modified'] = valueModified;

	var valueTransactionId = $formValues.find('.valueTransactionId').val();
	if(valueTransactionId != null && valueTransactionId !== '')
		vals['transactionId'] = valueTransactionId;

	var valueAccountKey = $formValues.find('.valueAccountKey').val();
	if(valueAccountKey != null && valueAccountKey !== '')
		vals['accountKey'] = valueAccountKey;

	var valueTransactionCode = $formValues.find('.valueTransactionCode').val();
	if(valueTransactionCode != null && valueTransactionCode !== '')
		vals['transactionCode'] = valueTransactionCode;

	var valueTransactionFee = $formValues.find('.valueTransactionFee').prop('checked');
	if(valueTransactionFee != null && valueTransactionFee !== '')
		vals['transactionFee'] = valueTransactionFee;

	var valueTransactionDisplayName = $formValues.find('.valueTransactionDisplayName').val();
	if(valueTransactionDisplayName != null && valueTransactionDisplayName !== '')
		vals['transactionDisplayName'] = valueTransactionDisplayName;

	var valueTransactionReferenceId = $formValues.find('.valueTransactionReferenceId').val();
	if(valueTransactionReferenceId != null && valueTransactionReferenceId !== '')
		vals['transactionReferenceId'] = valueTransactionReferenceId;

	var valueTransactionAmount = $formValues.find('.valueTransactionAmount').val();
	if(valueTransactionAmount != null && valueTransactionAmount !== '')
		vals['transactionAmount'] = valueTransactionAmount;

	var valueTransactionDateTime = $formValues.find('.valueTransactionDateTime').val();
	if(valueTransactionDateTime != null && valueTransactionDateTime !== '')
		vals['transactionDateTime'] = valueTransactionDateTime;

	var valueTransactionCompleteName = $formValues.find('.valueTransactionCompleteName').val();
	if(valueTransactionCompleteName != null && valueTransactionCompleteName !== '')
		vals['transactionCompleteName'] = valueTransactionCompleteName;

	$.ajax({
		url: '/api/transaction'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

function postBankTransactionVals(vals, success, error) {
	$.ajax({
		url: '/api/transaction'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// PATCH //

function patchBankTransaction($formFilters, $formValues, success, error) {
	var filters = patchBankTransactionFilters($formFilters);

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

	var removeTransactionId = $formFilters.find('.removeTransactionId').val() === 'true';
	var setTransactionId = removeTransactionId ? null : $formValues.find('.setTransactionId').val();
	if(removeTransactionId || setTransactionId != null && setTransactionId !== '')
		vals['setTransactionId'] = setTransactionId;
	var addTransactionId = $formValues.find('.addTransactionId').val();
	if(addTransactionId != null && addTransactionId !== '')
		vals['addTransactionId'] = addTransactionId;
	var removeTransactionId = $formValues.find('.removeTransactionId').val();
	if(removeTransactionId != null && removeTransactionId !== '')
		vals['removeTransactionId'] = removeTransactionId;

	var removeAccountKey = $formFilters.find('.removeAccountKey').val() === 'true';
	var setAccountKey = removeAccountKey ? null : $formValues.find('.setAccountKey').val();
	if(removeAccountKey || setAccountKey != null && setAccountKey !== '')
		vals['setAccountKey'] = setAccountKey;
	var addAccountKey = $formValues.find('.addAccountKey').val();
	if(addAccountKey != null && addAccountKey !== '')
		vals['addAccountKey'] = addAccountKey;
	var removeAccountKey = $formValues.find('.removeAccountKey').val();
	if(removeAccountKey != null && removeAccountKey !== '')
		vals['removeAccountKey'] = removeAccountKey;

	var removeTransactionCode = $formFilters.find('.removeTransactionCode').val() === 'true';
	var setTransactionCode = removeTransactionCode ? null : $formValues.find('.setTransactionCode').val();
	if(removeTransactionCode || setTransactionCode != null && setTransactionCode !== '')
		vals['setTransactionCode'] = setTransactionCode;
	var addTransactionCode = $formValues.find('.addTransactionCode').val();
	if(addTransactionCode != null && addTransactionCode !== '')
		vals['addTransactionCode'] = addTransactionCode;
	var removeTransactionCode = $formValues.find('.removeTransactionCode').val();
	if(removeTransactionCode != null && removeTransactionCode !== '')
		vals['removeTransactionCode'] = removeTransactionCode;

	var removeTransactionFee = $formFilters.find('.removeTransactionFee').val() === 'true';
	var setTransactionFee = removeTransactionFee ? null : $formValues.find('.setTransactionFee').prop('checked');
	if(removeTransactionFee || setTransactionFee != null && setTransactionFee !== '')
		vals['setTransactionFee'] = setTransactionFee;
	var addTransactionFee = $formValues.find('.addTransactionFee').prop('checked');
	if(addTransactionFee != null && addTransactionFee !== '')
		vals['addTransactionFee'] = addTransactionFee;
	var removeTransactionFee = $formValues.find('.removeTransactionFee').prop('checked');
	if(removeTransactionFee != null && removeTransactionFee !== '')
		vals['removeTransactionFee'] = removeTransactionFee;

	var removeTransactionDisplayName = $formFilters.find('.removeTransactionDisplayName').val() === 'true';
	var setTransactionDisplayName = removeTransactionDisplayName ? null : $formValues.find('.setTransactionDisplayName').val();
	if(removeTransactionDisplayName || setTransactionDisplayName != null && setTransactionDisplayName !== '')
		vals['setTransactionDisplayName'] = setTransactionDisplayName;
	var addTransactionDisplayName = $formValues.find('.addTransactionDisplayName').val();
	if(addTransactionDisplayName != null && addTransactionDisplayName !== '')
		vals['addTransactionDisplayName'] = addTransactionDisplayName;
	var removeTransactionDisplayName = $formValues.find('.removeTransactionDisplayName').val();
	if(removeTransactionDisplayName != null && removeTransactionDisplayName !== '')
		vals['removeTransactionDisplayName'] = removeTransactionDisplayName;

	var removeTransactionReferenceId = $formFilters.find('.removeTransactionReferenceId').val() === 'true';
	var setTransactionReferenceId = removeTransactionReferenceId ? null : $formValues.find('.setTransactionReferenceId').val();
	if(removeTransactionReferenceId || setTransactionReferenceId != null && setTransactionReferenceId !== '')
		vals['setTransactionReferenceId'] = setTransactionReferenceId;
	var addTransactionReferenceId = $formValues.find('.addTransactionReferenceId').val();
	if(addTransactionReferenceId != null && addTransactionReferenceId !== '')
		vals['addTransactionReferenceId'] = addTransactionReferenceId;
	var removeTransactionReferenceId = $formValues.find('.removeTransactionReferenceId').val();
	if(removeTransactionReferenceId != null && removeTransactionReferenceId !== '')
		vals['removeTransactionReferenceId'] = removeTransactionReferenceId;

	var removeTransactionAmount = $formFilters.find('.removeTransactionAmount').val() === 'true';
	var setTransactionAmount = removeTransactionAmount ? null : $formValues.find('.setTransactionAmount').val();
	if(removeTransactionAmount || setTransactionAmount != null && setTransactionAmount !== '')
		vals['setTransactionAmount'] = setTransactionAmount;
	var addTransactionAmount = $formValues.find('.addTransactionAmount').val();
	if(addTransactionAmount != null && addTransactionAmount !== '')
		vals['addTransactionAmount'] = addTransactionAmount;
	var removeTransactionAmount = $formValues.find('.removeTransactionAmount').val();
	if(removeTransactionAmount != null && removeTransactionAmount !== '')
		vals['removeTransactionAmount'] = removeTransactionAmount;

	var removeTransactionDateTime = $formFilters.find('.removeTransactionDateTime').val() === 'true';
	var setTransactionDateTime = removeTransactionDateTime ? null : $formValues.find('.setTransactionDateTime').val();
	if(removeTransactionDateTime || setTransactionDateTime != null && setTransactionDateTime !== '')
		vals['setTransactionDateTime'] = setTransactionDateTime;
	var addTransactionDateTime = $formValues.find('.addTransactionDateTime').val();
	if(addTransactionDateTime != null && addTransactionDateTime !== '')
		vals['addTransactionDateTime'] = addTransactionDateTime;
	var removeTransactionDateTime = $formValues.find('.removeTransactionDateTime').val();
	if(removeTransactionDateTime != null && removeTransactionDateTime !== '')
		vals['removeTransactionDateTime'] = removeTransactionDateTime;

	var removeTransactionCompleteName = $formFilters.find('.removeTransactionCompleteName').val() === 'true';
	var setTransactionCompleteName = removeTransactionCompleteName ? null : $formValues.find('.setTransactionCompleteName').val();
	if(removeTransactionCompleteName || setTransactionCompleteName != null && setTransactionCompleteName !== '')
		vals['setTransactionCompleteName'] = setTransactionCompleteName;
	var addTransactionCompleteName = $formValues.find('.addTransactionCompleteName').val();
	if(addTransactionCompleteName != null && addTransactionCompleteName !== '')
		vals['addTransactionCompleteName'] = addTransactionCompleteName;
	var removeTransactionCompleteName = $formValues.find('.removeTransactionCompleteName').val();
	if(removeTransactionCompleteName != null && removeTransactionCompleteName !== '')
		vals['removeTransactionCompleteName'] = removeTransactionCompleteName;

	patchBankTransactionVals(filters, vals, success, error);
}

function patchBankTransactionFilters($formFilters) {
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

	var filterTransactionId = $formFilters.find('.valueTransactionId').val();
	if(filterTransactionId != null && filterTransactionId !== '')
		filters.push({ name: 'fq', value: 'transactionId:' + filterTransactionId });

	var filterAccountKey = $formFilters.find('.valueAccountKey').val();
	if(filterAccountKey != null && filterAccountKey !== '')
		filters.push({ name: 'fq', value: 'accountKey:' + filterAccountKey });

	var filterTransactionCode = $formFilters.find('.valueTransactionCode').val();
	if(filterTransactionCode != null && filterTransactionCode !== '')
		filters.push({ name: 'fq', value: 'transactionCode:' + filterTransactionCode });

	var filterTransactionFee = $formFilters.find('.valueTransactionFee').prop('checked');
	if(filterTransactionFee != null && filterTransactionFee === true)
		filters.push({ name: 'fq', value: 'transactionFee:' + filterTransactionFee });

	var filterTransactionDisplayName = $formFilters.find('.valueTransactionDisplayName').val();
	if(filterTransactionDisplayName != null && filterTransactionDisplayName !== '')
		filters.push({ name: 'fq', value: 'transactionDisplayName:' + filterTransactionDisplayName });

	var filterTransactionReferenceId = $formFilters.find('.valueTransactionReferenceId').val();
	if(filterTransactionReferenceId != null && filterTransactionReferenceId !== '')
		filters.push({ name: 'fq', value: 'transactionReferenceId:' + filterTransactionReferenceId });

	var filterTransactionAmount = $formFilters.find('.valueTransactionAmount').val();
	if(filterTransactionAmount != null && filterTransactionAmount !== '')
		filters.push({ name: 'fq', value: 'transactionAmount:' + filterTransactionAmount });

	var filterTransactionDateTime = $formFilters.find('.valueTransactionDateTime').val();
	if(filterTransactionDateTime != null && filterTransactionDateTime !== '')
		filters.push({ name: 'fq', value: 'transactionDateTime:' + filterTransactionDateTime });

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

	var filterTransactionKey = $formFilters.find('.valueTransactionKey').val();
	if(filterTransactionKey != null && filterTransactionKey !== '')
		filters.push({ name: 'fq', value: 'transactionKey:' + filterTransactionKey });

	var filterAccountCompleteName = $formFilters.find('.valueAccountCompleteName').val();
	if(filterAccountCompleteName != null && filterAccountCompleteName !== '')
		filters.push({ name: 'fq', value: 'accountCompleteName:' + filterAccountCompleteName });

	var filterAccountNumber = $formFilters.find('.valueAccountNumber').val();
	if(filterAccountNumber != null && filterAccountNumber !== '')
		filters.push({ name: 'fq', value: 'accountNumber:' + filterAccountNumber });

	var filterTransactionCodeCompleteName = $formFilters.find('.valueTransactionCodeCompleteName').val();
	if(filterTransactionCodeCompleteName != null && filterTransactionCodeCompleteName !== '')
		filters.push({ name: 'fq', value: 'transactionCodeCompleteName:' + filterTransactionCodeCompleteName });

	var filterTransactionDate = $formFilters.find('.valueTransactionDate').val();
	if(filterTransactionDate != null && filterTransactionDate !== '')
		filters.push({ name: 'fq', value: 'transactionDate:' + filterTransactionDate });

	var filterTransactionCompleteName = $formFilters.find('.valueTransactionCompleteName').val();
	if(filterTransactionCompleteName != null && filterTransactionCompleteName !== '')
		filters.push({ name: 'fq', value: 'transactionCompleteName:' + filterTransactionCompleteName });

	var filterPageUrl = $formFilters.find('.valuePageUrl').val();
	if(filterPageUrl != null && filterPageUrl !== '')
		filters.push({ name: 'fq', value: 'pageUrl:' + filterPageUrl });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });
	return filters;
}

function patchBankTransactionVal(filters, v, val, success, error) {
	var vals = {};
	vals[v] = val;
	patchBankTransactionVals(filters, vals, success, error);
}

function patchBankTransactionVals(filters, vals, success, error) {
	$.ajax({
		url: '/api/transaction?' + $.param(filters)
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// GET //

function getBankTransaction(pk) {
	$.ajax({
		url: '/api/transaction/' + id
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

// DELETE //

function deleteBankTransaction(pk) {
	$.ajax({
		url: '/api/transaction/' + id
		, dataType: 'json'
		, type: 'DELETE'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// Search //

function searchBankTransaction($formFilters, success, error) {
	var filters = searchBankTransactionFilters($formFilters);
	if(success == null)
		success = function( data, textStatus, jQxhr ) {};
	if(error == null)
		error = function( jqXhr, textStatus, errorThrown ) {};

	searchBankTransactionVals(filters, success, error);
}

function searchBankTransactionFilters($formFilters) {
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

	var filterTransactionId = $formFilters.find('.valueTransactionId').val();
	if(filterTransactionId != null && filterTransactionId !== '')
		filters.push({ name: 'fq', value: 'transactionId:' + filterTransactionId });

	var filterAccountKey = $formFilters.find('.valueAccountKey').val();
	if(filterAccountKey != null && filterAccountKey !== '')
		filters.push({ name: 'fq', value: 'accountKey:' + filterAccountKey });

	var filterTransactionCode = $formFilters.find('.valueTransactionCode').val();
	if(filterTransactionCode != null && filterTransactionCode !== '')
		filters.push({ name: 'fq', value: 'transactionCode:' + filterTransactionCode });

	var filterTransactionFee = $formFilters.find('.valueTransactionFee').prop('checked');
	if(filterTransactionFee != null && filterTransactionFee === true)
		filters.push({ name: 'fq', value: 'transactionFee:' + filterTransactionFee });

	var filterTransactionDisplayName = $formFilters.find('.valueTransactionDisplayName').val();
	if(filterTransactionDisplayName != null && filterTransactionDisplayName !== '')
		filters.push({ name: 'fq', value: 'transactionDisplayName:' + filterTransactionDisplayName });

	var filterTransactionReferenceId = $formFilters.find('.valueTransactionReferenceId').val();
	if(filterTransactionReferenceId != null && filterTransactionReferenceId !== '')
		filters.push({ name: 'fq', value: 'transactionReferenceId:' + filterTransactionReferenceId });

	var filterTransactionAmount = $formFilters.find('.valueTransactionAmount').val();
	if(filterTransactionAmount != null && filterTransactionAmount !== '')
		filters.push({ name: 'fq', value: 'transactionAmount:' + filterTransactionAmount });

	var filterTransactionDateTime = $formFilters.find('.valueTransactionDateTime').val();
	if(filterTransactionDateTime != null && filterTransactionDateTime !== '')
		filters.push({ name: 'fq', value: 'transactionDateTime:' + filterTransactionDateTime });

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

	var filterTransactionKey = $formFilters.find('.valueTransactionKey').val();
	if(filterTransactionKey != null && filterTransactionKey !== '')
		filters.push({ name: 'fq', value: 'transactionKey:' + filterTransactionKey });

	var filterAccountCompleteName = $formFilters.find('.valueAccountCompleteName').val();
	if(filterAccountCompleteName != null && filterAccountCompleteName !== '')
		filters.push({ name: 'fq', value: 'accountCompleteName:' + filterAccountCompleteName });

	var filterAccountNumber = $formFilters.find('.valueAccountNumber').val();
	if(filterAccountNumber != null && filterAccountNumber !== '')
		filters.push({ name: 'fq', value: 'accountNumber:' + filterAccountNumber });

	var filterTransactionCodeCompleteName = $formFilters.find('.valueTransactionCodeCompleteName').val();
	if(filterTransactionCodeCompleteName != null && filterTransactionCodeCompleteName !== '')
		filters.push({ name: 'fq', value: 'transactionCodeCompleteName:' + filterTransactionCodeCompleteName });

	var filterTransactionDate = $formFilters.find('.valueTransactionDate').val();
	if(filterTransactionDate != null && filterTransactionDate !== '')
		filters.push({ name: 'fq', value: 'transactionDate:' + filterTransactionDate });

	var filterTransactionCompleteName = $formFilters.find('.valueTransactionCompleteName').val();
	if(filterTransactionCompleteName != null && filterTransactionCompleteName !== '')
		filters.push({ name: 'fq', value: 'transactionCompleteName:' + filterTransactionCompleteName });

	var filterPageUrl = $formFilters.find('.valuePageUrl').val();
	if(filterPageUrl != null && filterPageUrl !== '')
		filters.push({ name: 'fq', value: 'pageUrl:' + filterPageUrl });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });
	return filters;
}

function searchBankTransactionVals(filters, success, error) {
	$.ajax({
		url: '/api/transaction?' + $.param(filters)
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

function suggestBankTransactionAccountKey($formFilters, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fa fa-money-check w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['accountCompleteName']);
			var $a = $('<a>').attr('href', o['pageUrl']);
			$a.append($i);
			$a.append($span);
			var pk = parseInt($('#BankTransactionForm :input[name="pk"]').val());
			var val = o['yearKeys'];
			var checked = Array.isArray(val) ? val.includes(pk) : val == pk;
			var $input = $('<input>');
			$input.attr('id', 'GET_accountKey_' + pk + '_yearKeys_' + o['pk']);
			$input.attr('class', 'w3-check ');
			$input.attr('onchange', "var $input = $('#GET_accountKey_" + pk + "_yearKeys_" + o['pk'] + "'); patchBankTransactionVals([{ name: 'fq', value: 'pk:" + pk + "' }], { [($input.prop('checked') ? 'set' : 'remove') + 'AccountKey']: \"" + o['pk'] + "\" }, function() { patchBankAccountVals([{ name: 'fq', value: 'pk:" + o['pk'] + "' }], {}, function() { addGlow($input); }, function() { addError($input); } ); } ); ");
			$input.attr('onclick', 'removeGlow($(this)); ');
			$input.attr('type', 'checkbox');
			if(checked)
				$input.attr('checked', 'checked');
			var $li = $('<li>');
			$li.append($input);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	searchBankAccount($formFilters, success, error);
}

function suggestBankTransactionObjectSuggest($formFilters, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-cash-register w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['transactionCompleteName']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['pageUrl']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	searchBankTransactionVals($formFilters, success, error);
}
