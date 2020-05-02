package com.softserve.edu.greencity.ui.data;

import java.util.List;

public class OneNewsData {
	
	  	private String title;
	    private List<String> tags;
	    //private String source;
	    private String content;

	    public OneNewsData( List<String> tags,  String title, String content) {
	        this.title = title;
	        this.tags = tags;
	        //this.source = source;
	        this.content = content;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public List<String> getTags() {
	        return tags;
	    }

//	    public String getSource() {
//	        return source;
//	    }

	    public String getContent() {
	        return content;
	    }

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			OneNewsData other = (OneNewsData) obj;
			if (content == null) {
				if (other.content != null)
					return false;
			} else if (!content.equals(other.content))
				return false;
			if (tags == null) {
				if (other.tags != null)
					return false;
			} else if (!tags.equals(other.tags))
				return false;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;
			return true;
		}
	    
	    
}
