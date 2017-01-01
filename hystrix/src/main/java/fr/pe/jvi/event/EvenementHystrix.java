package fr.pe.jvi.event;

public class EvenementHystrix
{
	/** L'id du hystrix*/
	private final long m_hystrixId;
	
	/** Le nom du hystrix*/
	private final String m_hystrixName;
	
	public EvenementHystrix(final String p_hystrixName, final long p_hystrixId)
	{
		m_hystrixId = p_hystrixId;
		m_hystrixName = p_hystrixName;
	}

	/**
	 * @return the m_hystrixId
	 */
	public long getHystrixId() {
		return m_hystrixId;
	}

	/**
	 * @return the m_hystrixName
	 */
	public String getHystrixName() {
		return m_hystrixName;
	}

	@Override
	public String toString() {
		return "Evenementhystrix [m_hystrixId=" + m_hystrixId + ", m_hystrixName="
				+ m_hystrixName + "]";
	}
}
