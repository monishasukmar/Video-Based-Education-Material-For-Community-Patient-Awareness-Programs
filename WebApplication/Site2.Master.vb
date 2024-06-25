Public Class Site2
    Inherits System.Web.UI.MasterPage

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

    End Sub

    Private Sub lnkAddPre_Click(sender As Object, e As EventArgs) Handles lnkAddPre.Click
        Session("where") = "AddPreQuestion.aspx"
        Response.Redirect("ChooseCourse.aspx")
    End Sub

    Private Sub lnkviewPre_Click(sender As Object, e As EventArgs) Handles lnkviewPre.Click
        Session("where") = "ViewPreQuestions.aspx"
        Response.Redirect("ChooseCourse.aspx")
    End Sub

    Private Sub lnkslide_Click(sender As Object, e As EventArgs) Handles lnkslide.Click
        Session("where") = "AddSlide.aspx"
        Response.Redirect("ChooseCourse.aspx")
    End Sub

    Private Sub lnkAddPost_Click(sender As Object, e As EventArgs) Handles lnkAddPost.Click
        Session("where") = "AddPostQuestions.aspx"
        Response.Redirect("ChooseCourse.aspx")
    End Sub

    Private Sub lnkViewPost_Click(sender As Object, e As EventArgs) Handles lnkViewPost.Click
        Session("where") = "ViewPostQuestions.aspx"
        Response.Redirect("ChooseCourse.aspx")
    End Sub

    Private Sub lnkReport_Click(sender As Object, e As EventArgs) Handles lnkReport.Click
        Session("where") = "Report.aspx"
        Response.Redirect("ChooseCourse.aspx")
    End Sub
End Class