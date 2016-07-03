define(['jquery', 'backbone', 'handlebars', 'hbs!app/templates/menu'], 
		function($, Backbone, Handlebars, template) {
	
	// Module Below
	var MenuView = Backbone.View.extend({
		
		initialize : function () {
			this.listenTo( this.collection, "reset", this.render);
			this.listenTo( this.collection, "add", this.render);
			this.listenTo( this.collection, "remove", this.render);
		},
		
		render: function() {
			this.$el.html( template(this.collection));		
			return this;
		}
		
	});
	
	// exports
	return MenuView;
});