package fr.pe.jvi.intercepteur;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Audit
@Interceptor
public class AuditInterceptor implements Serializable {

  private static final long serialVersionUID = 1L;

  @AroundInvoke
  public Object auditMethodCall(InvocationContext invocationContext)
      throws Exception
  {
		System.out.println("[AUDIT] Interception de la méthode :" + invocationContext.getMethod().getName());
    return invocationContext.proceed();
  }

}