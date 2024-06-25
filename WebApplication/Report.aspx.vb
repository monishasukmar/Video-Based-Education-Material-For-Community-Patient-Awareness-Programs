Imports MySql.Data.MySqlClient

Public Class WebForm10
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        Dim con As New MySqlConnection(constr)
        con.Open()
        Dim com As New MySqlCommand(String.Format("SELECT min(id) as md,dt,count(patientname) as totp,avg(prescore) as psa,avg(postscore) as posa FROM app.scores where coursecode='{0}' group by dt;", Session("selid")), con)
        Dim rs As MySqlDataReader
        rs = com.ExecuteReader
        Dim sno As Integer = 1
        While rs.Read
            Dim tr As New TableRow
            Dim tsno, tdt, tpatient, tpre, tpost, tview As New TableCell
            tsno.Text = sno
            tdt.Text = CDate(rs("dt")).ToString("dd/MM/yyyy hh:mm:ss")
            tpatient.Text = rs("totp")
            tpre.Text = rs("psa")
            tpost.Text = rs("posa")
            Dim ll As New LinkButton
            ll.Text = "View"
            ll.Attributes.Add("lda", rs("md"))
            AddHandler ll.Click, AddressOf rep1
            tview.Controls.Add(ll)
            tr.Cells.Add(tsno)
            tr.Cells.Add(tdt)
            tr.Cells.Add(tpatient)
            tr.Cells.Add(tpre)
            tr.Cells.Add(tpost)
            tr.Cells.Add(tview)
            tsno.Attributes.Add("class", "tdcenter")
            tdt.Attributes.Add("class", "tdnormal")
            tpatient.Attributes.Add("class", "tdcenter")
            tpre.Attributes.Add("class", "tdcenter")
            tpost.Attributes.Add("class", "tdcenter")
            tview.Attributes.Add("class", "tdcenter")
            Table1.Rows.Add(tr)
            sno = sno + 1
        End While
        rs.Close()
        con.Close()
    End Sub

    Public Sub rep1(s As Object, e As EventArgs)
        Dim l As LinkButton = s
        Dim dt As String = l.Attributes("lda")
        Session("dtsel") = dt
        Response.Redirect("Report1.aspx")
    End Sub

End Class