package au.com.vaadinutils.jasper.scheduler;

import java.util.Date;

import org.joda.time.DateTime;

import au.com.vaadinutils.jasper.JasperManager.OutputFormat;
import au.com.vaadinutils.jasper.scheduler.entities.ScheduleMode;

public class DayOfMonthSchedule extends ReportEmailScheduleTestAdaptor
{

	private Date lastRuntime = null;
	final DateTime scheduledTime ;
	private int dayOfMonth;
	private Date nextScheduledTime;

	DayOfMonthSchedule(Date date,int dayOfMonth)
	{
		scheduledTime = new DateTime(date);
		this.dayOfMonth = dayOfMonth;
		nextScheduledTime = getScheduleMode().getNextRuntime(this, new Date());
	}
	
	@Override
	public String getScheduledDaysOfWeek()
	{
		return null;
	}

	@Override
	public Integer getScheduledDayOfMonth()
	{

		return dayOfMonth;
	}

	@Override
	public Date getTimeOfDayToRun()
	{

		return scheduledTime.toDate();
	}

	@Override
	public Date getOneTimeRunDateTime()
	{

		return null;
	}

	@Override
	public ScheduleMode getScheduleMode()
	{
		return ScheduleMode.DAY_OF_MONTH;
	}

	@Override
	public Date getLastRuntime()
	{

		return lastRuntime;
	}

	@Override
	public void setLastRuntime(Date date, String auditDetails)
	{
		lastRuntime = date;
		System.out.println(auditDetails);

	}

	@Override
	public void setEnabled(boolean b)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEnabled()
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getSendersUsername()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getNextScheduledTime()
	{
		return nextScheduledTime;
	}

	@Override
	public void setNextScheduledRunTime(Date nextRuntime)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public OutputFormat getOutputFormat()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
