package com.softserve.edu.greencity.rest.data.econews;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.greencity.rest.entity.pageEntity.NewsEntity;


public class NewsItems {
	
		private String title;
		private String text;
		
		public NewsItems(String title, String text) {
			this.title = title;
			this.text = text;
		}
	
		public String getTitle() {
			return title;
		}

		public String getText() {
			return text;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setText(String text) {
			this.text = text;
		}

		// static factory
		public static NewsItems converToNewsItems(NewsEntity newsEntity) {
			return new NewsItems(newsEntity.getTitle(), newsEntity.getText());
		}
		
		public static List<NewsItems> converToNewsItemsList(List<NewsEntity> newsEntities) {
			List<NewsItems> result = new ArrayList<>();
			for (NewsEntity newsEntity : newsEntities) {
				result.add(converToNewsItems(newsEntity));
			}
			return result;
		}

}
