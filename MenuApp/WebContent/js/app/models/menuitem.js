define(['jquery', 'backbone'], 
		function($, Backbone) {
	
	// Module Below
	var MenuItem = Backbone.Model.extend({
		
		defaults: {
			category: 'Snacks',
			imagepath: 'samosa.jpg',
			name: ''
		}
		
	});
	
	// exports
	return MenuItem;
});