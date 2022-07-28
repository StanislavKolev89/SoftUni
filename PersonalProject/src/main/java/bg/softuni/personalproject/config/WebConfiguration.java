package bg.softuni.personalproject.config;


import  org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
    public class WebConfiguration implements WebMvcConfigurer {

        private final LocaleChangeInterceptor localeChangeInterceptor;

    public WebConfiguration(LocaleChangeInterceptor localeChangeInterceptor) {
        this.localeChangeInterceptor = localeChangeInterceptor;
    }

//    @Override
//        public void addResourceHandlers(ResourceHandlerRegistry registry){
//            registry.addResourceHandler("/**")
//                    .addResourceLocations("classpath:/static/");
//        }

        @Override
         public void addInterceptors(InterceptorRegistry registry) {
          registry.addInterceptor(localeChangeInterceptor);
        }




    }

