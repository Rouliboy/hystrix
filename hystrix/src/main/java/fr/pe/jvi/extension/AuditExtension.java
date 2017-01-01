package fr.pe.jvi.extension;

import java.lang.annotation.Annotation;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

import fr.pe.jvi.beans.MonBeanCDI;
import fr.pe.jvi.intercepteur.Audit;

public class AuditExtension implements Extension {

  public <T> void processAnnotatedType(
      @Observes ProcessAnnotatedType<T> processAnnotatedType) {

    AnnotatedType<T> annotatedType = processAnnotatedType
        .getAnnotatedType();

    if (annotatedType.getJavaClass().equals(MonBeanCDI.class)) {

    	System.out.println("Ajout de l'annotation dans Auditextension");
      Annotation auditAnnotation = new Annotation() {
        @Override
        public Class<? extends Annotation> annotationType() {
          return Audit.class;
        }
      };

      AnnotatedTypeWrapper<T> wrapper = new AnnotatedTypeWrapper<T>(
          annotatedType, annotatedType.getAnnotations());
      wrapper.addAnnotation(auditAnnotation);

      processAnnotatedType.setAnnotatedType(wrapper);
    }

  }

}
