## Flickr Viewer
## Flickr.com image viewer app
## Приложение для просмотра изображений с [Flickr.com](https://www.flickr.com/services/api/flickr.photos.search.html)
- Для сетевого взаимодействия используется Retrofit 
- ViewModel выполненет сетевые запросы к бэкэнду для получения актуальных изображений 
- DataBinding и LiveData для обновления UI
- Moshi для преобразования JSON в объекты Kotlin
  
![Screenshot_1](/screenshots/Screenshot_1.png?raw=true)
![Screenshot_2](/screenshots/Screenshot_2.png?raw=true)
![Screenshot_3](/screenshots/Screenshot_3.png?raw=true)
  
[ResponseEntity] Object  
{  
    [ResponseMetadata] Object  
    "photos": {  
        "page": 1,  
        "pages": 1380,  
        "perpage": 100,  
        "total": 137992,  
        "photo": [  
            [PhotoEntity] Object  
            {  
                "id": "51613813929",  
                "owner": "73561613@N06",  
                "secret": "20cd20fe9f",  
                "server": "65535",  
                "farm": 66,  
                "title": "Golden Retrievers enjoying a run at the beach",  
                "ispublic": 1,  
                "isfriend": 0,  
                "isfamily": 0  
            }, ...  
        ]  
    },  
    "stat": "ok"  
}  
