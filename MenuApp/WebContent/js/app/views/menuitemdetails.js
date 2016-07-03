define(['jquery', 'backbone', 'handlebars', 'hbs!app/templates/menuitemdetails'], 
		function($, Backbone, Handlebars, template) {
	
	// Module Below
	var MenuItemDetails = Backbone.View.extend({
		
		initialize: function() {
			this.listenTo( this.model, "change", this.render);
		},
		
		render: function() {
			this.$el.html( template(this.model.attributes));			
			return this;
		}
		
	});
	
	// exports
	return MenuItemDetails;
});