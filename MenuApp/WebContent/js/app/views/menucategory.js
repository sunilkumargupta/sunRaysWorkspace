define(['jquery', 'backbone', 'handlebars', 'hbs!app/templates/menucategory'], 
		function($, Backbone, Handlebars, template) {
	
	// Module Below
	var MenuCategoryView = Backbone.View.extend({
		
		initialize : function (options) {
			  this.options = options || {};
		},
		
		render: function() {
			this.$el.html( template(this.options));			
			return this;
		}
		
	});
	
	// exports
	return MenuCategoryView;
});